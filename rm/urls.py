from django.urls import path,include

from .views import *

urlpatterns = [
    #path('extract-text/', extract_data, name='extract_text_from_dta'),
    path('upload_workspace_DTA/', upload_workspace_DTA, name='upload_workspace_DTA'),
    path('upload_workspace_BRL/', upload_workspace_BRL, name='upload_workspace_BRL'),
]