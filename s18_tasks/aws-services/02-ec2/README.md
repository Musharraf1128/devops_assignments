# EC2 - Compute

## What is EC2?

```
EC2 is a virtual computer in AWS. We pick size and OS, start it in
minutes, and pay while it runs. Good when we need full control of
the machine.
```

## AMI

```
AMI is the machine image with OS plus software baked in, like Ubuntu
with docker already installed. We launch copies from one AMI so all
servers start identical.
```

## Instance Types

```
Types fix CPU RAM and network, like t3.micro for small tests and
m5.large for real apps. Bigger type means more money, so we match
type to actual load.
```

## Key Pairs

```
Key pair is how we SSH in, AWS keeps public part and we keep private
pem file safe. Lose the pem and we can not login, anyone with pem
can login, so chmod 400 and never share it.
```

## Security Groups

```
Security group is a firewall around the instance. We open port 22
for our ip and port 80 for all, rest stays closed. Rules are allow
only, default is deny all.
```

## EBS

```
EBS is the hard disk attached to EC2. Root disk dies with instance
unless told otherwise, extra volumes keep data. We can snapshot EBS
for backup and make bigger volumes from snapshots.
```

## Public vs Private IP

```
Public ip is reachable from internet, private ip only inside VPC.
Web server needs public ip, database keeps private ip only so no
outsider can touch it directly.
```

## Instance Lifecycle

```
Pending means starting, running means working, stopping and stopped
means off but disk kept, terminated means gone with root disk. Stop
saves money, terminate deletes.
```

## Common Use Cases

```
Jenkins server, game backend, or anything needing custom setup that
containers can not do. Also bastion host to jump into private boxes.
```
