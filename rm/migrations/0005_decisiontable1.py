# Generated by Django 4.1.13 on 2024-04-11 19:43

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('rm', '0004_extractedrule'),
    ]

    operations = [
        migrations.CreateModel(
            name='DecisionTable1',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('file_name', models.CharField(max_length=255)),
                ('tag_data', models.JSONField()),
            ],
        ),
    ]
