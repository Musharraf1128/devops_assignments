# VPC - Networking

## What is VPC?

```
VPC is our own private network inside AWS. We pick the ip range and
split it in subnets, and nothing outside can enter unless we open
a door for it.
```

## CIDR

```
CIDR writes the range like 10.0.0.0/16 which means 65 thousand ips.
Bigger number after slash means smaller network. Subnets carve pieces
like 10.0.1.0/24 out of it.
```

## Subnets

```
Subnet is one slice in one zone, like 10.0.1.0/24 in ap-south-1a.
Public subnet has route to internet gateway, private subnet does not.
We put web in public and database in private.
```

## Route Tables

```
Route table tells subnet where packets go. Public table sends
0.0.0.0/0 to internet gateway. Private table sends it to NAT gateway
or nowhere. Each subnet follows exactly one table.
```

## Internet Gateway

```
Internet gateway connects public subnets to internet both ways.
Without it attached, even public ip instances can not be reached.
One gateway per VPC is enough.
```

## NAT Gateway

```
NAT gateway lets private subnets go out for updates but blocks
incoming traffic. It lives in a public subnet with elastic ip.
Database patches itself through NAT but stays hidden.
```

## Security Groups

```
Same firewall idea as EC2, attached at instance level. Web group
allows 80 from anywhere and 22 from my ip. DB group allows 5432
only from web group, so database talks only to our app.
```

## Network ACLs

```
NACL is a second firewall at subnet level. It checks both incoming
and outgoing with numbered rules. Mostly we leave default allow and
use security groups, NACL is for extra blocking.
```

## Public vs Private Subnet

```
Public subnet routes to internet gateway and hosts load balancer
and web servers. Private subnet has no such route and hosts app
servers and databases. Traffic between them goes through security
groups only.
```
