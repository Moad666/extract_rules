from django.db import models

class DecisionTable(models.Model):
    extracted_decision_table = models.TextField()

    def __str__(self):
        return self.extracted_decision_table