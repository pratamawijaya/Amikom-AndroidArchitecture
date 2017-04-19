# Contoh app

untuk menggunakan source code ini saya menyarakan anda untuk melakukan hal berikut:

## lakukan compilasi secara manual via command line

- buka commandline
- masuk ke directory project
- jalankan perintah

 Linux/Unix
```
./gradlew clean assembleDebug
```

Windows
```
gradlew.bat clean assembleDebug
```

hal ini untuk memastikan dependency yang dibutuhkan didownload terlebih dahulu.

## Sesuaikan Google Map API

Project ini menggunakan google map api, anda dapat menggunakan google api key anda sendiri, ubah nilai google api key
di file **app/src/debug/res/values/google_maps_api.xml**