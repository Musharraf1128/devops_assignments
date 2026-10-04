# IAM - Governance

## What is IAM?

```
IAM controls who can do what in AWS. Every person and app gets an
identity, and policies decide what that identity is allowed to touch.
No IAM means anyone with the account can do anything.
```

## Users

```
A user is one person or app login, like musharraf-dev. It has a
password for console and access keys for CLI. Each user gets only
the permissions they need.
```

## Groups

```
Groups collect users doing same work, like Developers or Admins.
We attach policies to the group once instead of every user. New
person just joins the group and gets everything.
```

## Roles

```
Roles are for temporary access, no password or keys stored. EC2
takes a role to read S3, or one account trusts a role from another
account. Credentials come and go automatically.
```

## Policies

```
Policies are JSON rules saying Allow or Deny on actions and resources.
Example allows s3:GetObject only on one bucket. Managed policies are
given by AWS, customer policies we write ourselves.
```

## Permissions and Least Privilege

```
Start with zero access and add only what the work needs. If app only
reads one bucket, give only s3:GetObject on that bucket. This way a
leaked key or bug can do very little damage.
```

## Best Practices

```
Never use root, lock it with MFA. Give humans IAM users with MFA,
give machines roles not keys. Rotate keys, remove unused users, and
check Access Analyzer for extra permissions.
```

## Common Use Cases

```
Dev team gets PowerUser except IAM, CI runner gets role to push ECR
and deploy, billing person gets read-only cost explorer. Each case
is one group plus one policy.
```
