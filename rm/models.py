from django.db import models

class ActionRules(models.Model):
    extracted_action_rules = models.TextField()

    def __str__(self):
        return self.extracted_action_rules
    
class DecisionTables(models.Model):
    extracted_decision_tables = models.TextField()

    def __str__(self):
        return self.extracted_decision_tables
    

class DecisionTable(models.Model):
    extracted_decision_table = models.TextField()

    def __str__(self):
        return self.extracted_decision_table
    
    
    
class ExtractedRule(models.Model):
    file_name = models.CharField(max_length=255)
    tag_data = models.JSONField()


class DecisionTable1(models.Model):
    file_name = models.CharField(max_length=255)
    tag_data = models.JSONField()