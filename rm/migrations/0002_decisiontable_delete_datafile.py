# Generated by Django 4.1.7 on 2024-04-09 16:09

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('rm', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='DecisionTable',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('extracted_decision_table', models.TextField()),
            ],
        ),
        migrations.DeleteModel(
            name='DataFile',
        ),
    ]
