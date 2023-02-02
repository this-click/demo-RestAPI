# Retrofit Demo app
Practice project for getting data from a custom built REST API (sometimes) running on an EC2 instance.
Usually I run it locally and update the BASE_URL accordingly.

API repo: https://github.com/this-click/demo-pet-RestApi

This app displays a list of 3 dogs retrieved from the API and a detailed view for each dog when clicked. 
If GET was unsuccessful, display a relevant image.

<img src="https://user-images.githubusercontent.com/88038974/212665494-e1056667-3a47-4521-a5dc-b872d0e86716.png" width="150" height="280">

<img src="https://user-images.githubusercontent.com/88038974/212665566-3fe4daa1-673b-4034-b04a-32f9e7c2a9fd.png" width="150" height="280">

<img src="https://user-images.githubusercontent.com/88038974/212688971-69d267f2-0476-4455-b239-9b364e4af2b6.png" width="150" height="280">

Notes:
- Course followed: Android basics in Kotlin, by Google.
- I didn't enable HTTPS yet on the API, so manifest includes clear text traffic flag.
