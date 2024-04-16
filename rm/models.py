from django.db import models

class Category(models.Model):
    name = models.CharField(max_length=50)


class DecisionTable1(models.Model):
    file_name = models.CharField(max_length=255, default="file_zip")
    category = models.ForeignKey(Category, on_delete=models.CASCADE, default=2)

    # Define attributes for each tag in the XML
    name = models.CharField(max_length=255)
    uuid = models.CharField(max_length=255)
    locale = models.CharField(max_length=255)
    definition = models.JSONField(default=dict)

    # Additional attributes from the XML
    preconditions_text = models.TextField(blank=True, null=True)
    structure_condition_expression = models.CharField(max_length=255, blank=True, null=True)
    action_definition_text = models.TextField(blank=True, null=True)
    partition_condition_expression = models.CharField(max_length=255, blank=True, null=True)
    partition_action_expression = models.TextField(blank=True, null=True)
    resources_data = models.CharField(max_length=255, blank=True, null=True)

    @classmethod
    def create_from_tag_data(cls, file_name, tag_data, category):
        #print(tag_data)
    # Extract necessary fields from tag_data
        name = tag_data.get('name')
        definition = tag_data.get('definition')
        preconditions_text = tag_data.get('definition', {}).get('DT', {}).get('Body', {}).get('preconditions_text')
        uuid = tag_data.get('uuid')
        locale = tag_data.get('locale')
        print("Creating instance with preconditions_text:", preconditions_text)
    # Create a new instance of DecisionTable1
        decision_table = cls.objects.create(
            file_name=file_name,
            name=name,
            definition=definition,
            preconditions_text=preconditions_text,
            category=category,
            uuid=uuid,
            locale=locale
        )

    # Return the newly created instance
        return decision_table


class ActionRule(models.Model):
    file_name = models.CharField(max_length=255, default="file_zip")
    category = models.ForeignKey(Category, on_delete=models.CASCADE, default=2)

    # Define attributes for each tag in the XML
    name = models.CharField(max_length=255)
    uuid = models.CharField(max_length=255)
    locale = models.CharField(max_length=255)
    definition = models.TextField()

    @classmethod
    def create_from_xml(cls, file_name, tag_data, category):
        name = tag_data.get('name')
        definition = tag_data.get('definition')
        uuid = tag_data.get('uuid')
        locale = tag_data.get('locale')
        
        action_rule = cls.objects.create(
            file_name=file_name,
            name=name,
            definition=definition,
            category=category,
            uuid=uuid,
            locale=locale
        )

        return action_rule