from django.db import models



    
class RuleCategory(models.Model):
    name = models.CharField(max_length=50)



class DecisionTable1(models.Model):
    file_name = models.CharField(max_length=255)
    tag_data = models.JSONField()
    rule_category = models.ForeignKey(RuleCategory, on_delete=models.CASCADE, default=2)
    parent_folder = models.CharField(max_length=255,  default='')
        




class ActionRule(models.Model):
    file_name = models.CharField(max_length=255)
    tag_data = models.JSONField()
    rule_category = models.ForeignKey(RuleCategory, on_delete=models.CASCADE)
    parent_folder = models.CharField(max_length=255)
    name = models.CharField(max_length=255)
    uuid = models.CharField(max_length=36)
    locale = models.CharField(max_length=10)
    definition = models.TextField()


class DecisionTable2(models.Model):
    file_name = models.CharField(max_length=255)
    tag_data = models.JSONField()
    rule_category = models.ForeignKey(RuleCategory, on_delete=models.CASCADE, default=2)
    parent_folder = models.CharField(max_length=255, default='')

    # Add new attributes based on the tags from the .dta file
    name = models.CharField(max_length=255)
    uuid = models.CharField(max_length=255)
    locale = models.CharField(max_length=50)
    version = models.CharField(max_length=10)
    domain = models.CharField(max_length=100) 
    rule_description = models.TextField()
    code = models.CharField(max_length=50)
    resolution = models.TextField()
    rule_name = models.CharField(max_length=255)
    source_queue = models.CharField(max_length=100)
    flight_segment_count_equal_0 = models.BooleanField()
    tags_count_equal_0 = models.BooleanField


class Queries(models.Model):
    file_name = models.CharField(max_length=255)
    tag_data = models.JSONField()
    rule_category = models.ForeignKey(RuleCategory, on_delete=models.CASCADE, default=4)
    parent_folder = models.CharField(max_length=255, default='')
    name = models.CharField(max_length=255)  # Add fields for each tag
    uuid = models.CharField(max_length=36)
    definition = models.TextField()
    locale = models.CharField(max_length=10)
    

class DecisionTable3(models.Model):
    file_name = models.CharField(max_length=255)
    rule_category = models.ForeignKey(RuleCategory, on_delete=models.CASCADE)
    parent_folder = models.CharField(max_length=255, default='')
    name = models.CharField(max_length=255)
    uuid = models.CharField(max_length=255)
    locale = models.CharField(max_length=10)
    body = models.TextField()
    resources = models.TextField()
    extracted_attributes = models.JSONField()


class DecisionTable4(models.Model):
    file_name = models.CharField(max_length=255)
    rule_category = models.ForeignKey(RuleCategory, on_delete=models.CASCADE)
    parent_folder = models.CharField(max_length=255, default='')
    name = models.CharField(max_length=255)
    uuid = models.CharField(max_length=255)
    locale = models.CharField(max_length=10)
    body = models.TextField()
    resources = models.TextField()
    extracted_attributes = models.JSONField()
