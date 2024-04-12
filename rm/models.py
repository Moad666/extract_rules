from django.db import models

class Category(models.Model):
    name = models.CharField(max_length=50)


class DecisionTable(models.Model):
    file_name = models.CharField(max_length=255, default="file_zip")
    tag_data = models.JSONField(default=dict)
    category = models.ForeignKey(Category, on_delete=models.CASCADE, default=2)

