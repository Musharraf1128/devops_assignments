# Terraform S3 Demo

Makes one S3 bucket with terraform. Bucket is musharraf-s18-demo-10447
in ap-south-1. Values come from terraform.tfvars file.

## 1. Init and Format

### Commands

```bash
terraform init
terraform fmt
terraform validate
```

### What I understood:

```
init downloads aws provider. fmt fixes spacing in files. validate
checks syntax without touching AWS. All three must pass before plan.
```

### Screenshot

![Terraform init](../images/s18-tf-init.png)

![Terraform fmt and validate](../images/s18-tf-fmt-validate.png)

## 2. Plan and Apply

### Commands

```bash
terraform plan
terraform apply
```

### What I understood:

```
plan shows what will happen, here 1 bucket to add and nothing to
change. apply asks yes and then makes the bucket. After apply the
state file remembers the bucket for next runs.
```

### Screenshot

![Terraform plan 1](../images/s18-tf-plan-1.png)
![Terraform plan 2](../images/s18-tf-plan-2.png)

![Terraform apply](../images/s18-tf-apply.png)

## 3. Show and Output

### Commands

```bash
terraform show
terraform output
```

### What I understood:

```
show prints full state with bucket id and arn. output prints only
the three values from outputs.tf file, name arn and region. Used
these to confirm bucket really exists.
```

### Screenshot

![Terraform show and output](../images/s18-tf-output.png)

## 4. Destroy

### Commands

```bash
terraform destroy
```

### What I understood:

```
destroy deletes the bucket since force_destroy is true even if empty.
Typed yes and it removed everything. State file becomes empty again.
Always destroy demo buckets so no bill comes.
```

### Screenshot

![Terraform destroy](../images/s18-tf-destroy.png)
