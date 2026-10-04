# DynamoDB & RDS - Database Services

## DynamoDB

### NoSQL

```
NoSQL means no fixed tables or joins. We store items and fetch by
key, which is fast at any size. Good when data shape keeps changing.
```

### Tables, Items, Attributes

```
Table is like a folder, item is one record, attribute is one field.
One item can have 3 fields and next item 10 fields, no problem.
```

### Partition Key and Sort Key

```
Partition key decides which storage box keeps the item, like user_id.
Sort key orders items inside that box, like order date. Both together
make each item unique and queries stay fast.
```

### Use Cases

```
Session store, cart, game scores, iot readings. Anything with huge
reads and writes by key where we do not need joins.
```

## RDS

### Relational Database

```
RDS is normal SQL database run by AWS. Tables with fixed columns and
joins work as usual, AWS handles patching and backup.
```

### Supported Engines

```
Postgres, MySQL, MariaDB, Oracle and SQL Server. We pick the one our
app already uses, most class work uses Postgres.
```

### DB Instances

```
Instance is the database server size, like db.t3.micro. Bigger
instance means more RAM for queries. Storage is separate EBS that
grows on its own.
```

### Security

```
Database lives in private subnet, security group allows port 5432
only from app servers. Password in Secrets Manager, SSL on for
connection. No public access ever.
```

### Backups

```
Daily automatic snapshots with set retention, plus manual snapshots
before big changes. Point in time restore brings back any second
inside retention window.
```

### Multi-AZ and Read Replicas

```
Multi-AZ keeps a hidden copy in another zone for failover, same
address after fail. Read replicas are extra copies we read from to
share load, but they can lag a little.
```

### Use Cases

```
User accounts, orders, anything needing joins and exact consistency.
When data must always agree, RDS wins over DynamoDB.
```
