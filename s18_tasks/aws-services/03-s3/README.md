# S3 - Storage

## What is S3?

```
S3 stores files as objects in buckets, unlimited size and always
available. No servers to manage, we just put and get files with
any name.
```

## Buckets

```
Bucket is the top folder with a globally unique name, like my-app-data.
All files live inside buckets, and bucket settings like versioning
apply to everything inside.
```

## Objects

```
Object is one file plus its metadata. Each object has a key which is
its path, plus size and type. Max one object is 5TB.
```

## Storage Classes

```
Standard for daily use, Intelligent moves data itself, Infrequent for
backups, Glacier for archive that can wait hours. Cheaper class means
slower first access, so we match class to how often we read.
```

## Versioning

```
Versioning keeps every overwrite as a new version. Delete by mistake
and we restore the old version. Costs extra storage but saves us
from data loss.
```

## Lifecycle Policies

```
Lifecycle rules move or delete objects by age, like images to Glacier
after 90 days and logs deleted after a year. Saves money without
manual cleanup.
```

## Encryption

```
SSE-S3 encrypts with AWS keys by default, SSE-KMS uses our own key
for control, client side means we encrypt before upload. Data is
always encrypted on disk now.
```

## Bucket Policies

```
Bucket policy is JSON saying who can do what on this bucket, like
allow CloudFront to read but deny plain HTTP. Works together with
IAM policies, deny wins always.
```

## Common Use Cases

```
Website static files, app backups, terraform state, docker registry
mirror, data lake for analytics. Anything that is files goes to S3.
```
