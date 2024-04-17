# serializers.py

from rest_framework import serializers
from .models import RuleCategory

class RuleCategorySerializer(serializers.ModelSerializer):
    class Meta:
        model = RuleCategory
        fields = ['name']

