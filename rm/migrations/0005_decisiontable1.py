# Generated by Django 4.1.7 on 2024-04-16 13:42

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('rm', '0004_remove_decisiontable_extracted_decision_table_and_more'),
    ]

    operations = [
        migrations.CreateModel(
            name='DecisionTable1',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('file_name', models.CharField(default='file_zip', max_length=255)),
                ('name', models.CharField(max_length=255)),
                ('uuid', models.CharField(max_length=255)),
                ('locale', models.CharField(max_length=255)),
                ('definition', models.JSONField(default=dict)),
                ('preconditions_text', models.TextField(blank=True, null=True)),
                ('structure_condition_expression', models.CharField(blank=True, max_length=255, null=True)),
                ('action_definition_text', models.TextField(blank=True, null=True)),
                ('partition_condition_expression', models.CharField(blank=True, max_length=255, null=True)),
                ('partition_action_expression', models.TextField(blank=True, null=True)),
                ('resources_data', models.CharField(blank=True, max_length=255, null=True)),
                ('category', models.ForeignKey(default=2, on_delete=django.db.models.deletion.CASCADE, to='rm.category')),
            ],
        ),
    ]
