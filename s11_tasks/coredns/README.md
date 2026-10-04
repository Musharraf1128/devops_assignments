# CoreDNS

## What is CoreDNS?

```
CoreDNS is cluster DNS server. It runs as pods in kube-system.
All pods ask it for service IPs.
```

```bash
kubectl get pods -n kube-system -l k8s-app=kube-dns
```

## Why Kubernetes uses CoreDNS

```
Pod IPs change always, so hardcoding IP fails. CoreDNS watches API
and updates records when service comes or goes. So apps use stable
names.
```

## How service discovery works

```
When we create service web-clusterip, CoreDNS adds A record for it.
Pod asks CoreDNS for that name, gets ClusterIP back, then kube-proxy
sends to one backend pod.
```

## How DNS queries are resolved

```
Pod checks /etc/resolv.conf, sends query to 10.96.0.10. If short name,
search suffix is added first. CoreDNS answers from cluster records,
else forwards outside for external domains like google.com.
```

## CoreDNS configuration

```bash
kubectl get cm coredns -n kube-system
kubectl get svc kube-dns -n kube-system
```

```
Main config is coredns Corefile. Upstream servers are for outside
queries. Cluster local queries are answered directly.
```

## How to troubleshoot DNS issues

```bash
kubectl get pods -n kube-system -l k8s-app=kube-dns
kubectl exec -it curl-client -- cat /etc/resolv.conf
kubectl exec -it curl-client -- nslookup kubernetes.default.svc.cluster.local
kubectl logs -n kube-system -l k8s-app=kube-dns
```

```
First check coredns pods running. Then check resolv.conf inside pod.
Then try nslookup short and FQDN. If fails check logs of coredns.
Common mistake is wrong namespace in name.
```
