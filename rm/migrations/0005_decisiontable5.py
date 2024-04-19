# Generated by Django 4.1.13 on 2024-04-18 22:39

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('rm', '0004_decisiontable4'),
    ]

    operations = [
        migrations.CreateModel(
            name='DecisionTable5',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('file_name', models.CharField(max_length=255)),
                ('tag_data', models.JSONField()),
                ('parent_folder', models.CharField(default='', max_length=255)),
                ('eAnnotations', models.JSONField(blank=True, null=True)),
                ('name', models.CharField(blank=True, max_length=255, null=True)),
                ('uuid', models.CharField(blank=True, max_length=36, null=True)),
                ('locale', models.CharField(blank=True, max_length=10, null=True)),
                ('definition', models.JSONField(blank=True, null=True)),
                ('rule_category', models.ForeignKey(default=2, on_delete=django.db.models.deletion.CASCADE, to='rm.rulecategory')),
            ],
        ),
    ]
