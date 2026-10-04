# Session 13: Kubernetes Storage, HPA & Probes

## 1. Kubernetes Volumes

### emptyDir

```bash
kubectl apply -f 01-kubernetes-volumes/emptydir-pod.yaml
kubectl get pod emptydir-demo
```

```
emptyDir is temp folder inside pod. Both containers can share it.
When pod dies data is gone. Good for cache or temp files.
See emptydir-pod.yaml, volume mountPath /data.
```

### hostPath

```bash
kubectl apply -f 01-kubernetes-volumes/hostpath-pod.yaml
kubectl get pod hostpath-demo
```

```
hostPath uses node folder /tmp/hostpath-data. Data stays on node
even if pod restarts. But if pod goes to other node data is lost.
Only for single node testing, not real use.
```

### PersistentVolume

```
PV is storage made by admin. It lives apart from pods. Example
pv.yaml makes 1Gi hostPath /tmp/student-data with Retain policy.
```

```bash
kubectl apply -f 01-kubernetes-volumes/pv.yaml
kubectl get pv student-pv
```

### PersistentVolumeClaim

```
PVC is request for storage by user. K8s binds PVC to free PV.
pvc.yaml asks 500Mi, it binds to student-pv above.
```

```bash
kubectl apply -f 01-kubernetes-volumes/pvc.yaml
kubectl get pvc student-pvc
```

### StorageClass

```
StorageClass makes PV automatically, no need to make PV by hand.
We just make PVC with storageClassName and it provisions disk.
On minikube default standard class uses hostpath provisioner.
```

```bash
kubectl get storageclass
```

### Dynamic provisioning

```
Means PVC creates PV by itself using StorageClass. No admin step.
Mini project pvc.yaml works like this, it gets Bound without
making PV first.
```

### Screenshot

![PV PVC and volume pods 1](../images/s13-volumes-1.png)

![PV PVC and volume pods 2](../images/s13-volumes-2.png)

---

## 2. HPA Hands-on

### Commands

```bash
minikube addons enable metrics-server
kubectl apply -f hpa/deployment.yaml
kubectl apply -f hpa/service.yaml
kubectl apply -f hpa/hpa.yml
kubectl get hpa hpa-demo
kubectl get pods -l app=hpa-demo
kubectl top pods
kubectl describe hpa hpa-demo
```

### Load generator

```bash
kubectl run load-gen --image=busybox:1.36 --restart=Never -- sh -c "while true; do wget -q -O- http://hpa-demo-service; done"
kubectl get hpa hpa-demo -w
kubectl get pods -l app=hpa-demo
kubectl top pods
kubectl delete pod load-gen
```

### What I understood:

```
HPA watches cpu and adds pods when load is high. Deployment has cpu
request 100m so HPA can count percent. At start 1 pod, after load it
went to more pods. top shows cpu going up. describe shows current
cpu percent and min 1 max 5.
```

### Screenshots

![HPA scaling 1](../images/s13-hpa-1.png)
![HPA scaling 2](../images/s13-hpa-2.png)

![HPA top and describe](../images/s13-hpa-top.png)

---

## 3. Mini Project

Files in mini-project/ folder: namespace.yaml, pvc.yaml, deployment.yaml,
service.yaml, hpa.yaml.

### Commands

```bash
kubectl apply -f mini-project/namespace.yaml
kubectl apply -f mini-project/pvc.yaml
kubectl apply -f mini-project/deployment.yaml
kubectl apply -f mini-project/service.yaml
kubectl apply -f mini-project/hpa.yaml
kubectl get all -n production-webapp
kubectl get hpa -n production-webapp
```

### What I understood:

```
Full app with own namespace production-webapp. PVC gives /data storage,
deployment has startup readiness liveness probes on /. Service is
ClusterIP and HPA keeps 2 to 5 pods on 50 percent cpu. It combines
storage plus probes plus HPA in one project.
```

### Screenshot

![Mini project resources 1](../images/s13-mini-1.png)

![Mini project resources 2](../images/s13-mini-2.png)
