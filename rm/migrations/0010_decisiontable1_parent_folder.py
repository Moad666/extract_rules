# Generated by Django 4.1.13 on 2024-04-16 16:21

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('rm', '0009_actionrule1'),
    ]

    operations = [
        migrations.AddField(
            model_name='decisiontable1',
            name='parent_folder',
            field=models.CharField(default='', max_length=255),
        ),
    ]