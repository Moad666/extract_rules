from django.urls import path, include

from .views import login, signup, test_token, user_detail, user_list
urlpatterns = [

    path("login/", login, name="login"),
    path("signup/", signup, name="signup"),
    path("test_token/", test_token, name="test_token"),
    path("", user_list, name="user_list"),
    path("<int:pk>/", user_detail, name="user_detail"),
]
