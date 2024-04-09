from django.urls import path,include
from .views import upload_workspace, upload_workspace_DTA
urlpatterns = [
     path('upload_workspace/', upload_workspace, name='upload_workspace'),
     path('upload_workspace_DTA/', upload_workspace_DTA, name='upload_workspace_DTA'),
]