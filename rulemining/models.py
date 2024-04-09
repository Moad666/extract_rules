from django.db import models

class ActionRules(models.Model):
    extracted_action_rules = models.TextField()

    def __str__(self):
        return self.extracted_action_rules
