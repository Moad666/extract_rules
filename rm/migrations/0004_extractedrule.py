# Generated by Django 4.1.13 on 2024-04-11 16:36

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('rm', '0003_decisiontable'),
    ]

    operations = [
        migrations.CreateModel(
            name='ExtractedRule',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('file_name', models.CharField(max_length=255)),
                ('tag_data', models.JSONField()),
            ],
        ),
    ]
