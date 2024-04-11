from django.urls import path,include
from .views import upload_workspace, upload_workspace_DTA, upload_workspace_Queries
urlpatterns = [
     path('upload_workspace/', upload_workspace, name='upload_workspace'),
     path('upload_workspace_DTA/', upload_workspace_DTA, name='upload_workspace_DTA'),
     path('upload_workspace_Queries/', upload_workspace_Queries, name='upload_workspace_Queries'),
]