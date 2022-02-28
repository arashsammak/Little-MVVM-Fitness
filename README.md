
# Little Fitness 💪

With this little and minimal application, you can discover the main activities that help you stay healthy and fit


## Project Stracture ⚙️

This Application is based on **MVVM** architecture and is written in **Kotlin** 

The project contains two main parts:


**Application**

The application contains these packages:

* `binding_adapter/` : contains binding adapter classes 
* `data/` : contains all data and database related classes 
* `di/` : contains dependency injection class 
* `repository/` : contains bussiness logic
* `ui/` : all UI related classes
* `util/` : contains Constants and PrefrencesHelper classes
* `viewmodel/` : hosts viewmodel class


**Tests**
* `data/db/` automated tests to check DAO funcnality
* `ui/fragment/` automated tests to check UI components 










## Screenshots

Exercises List (Exercises Fragment)             |  Exercise Detail (Detail Fragment)
:-------------------------:|:-------------------------:
<img src="http://bahareng.com/assets/2.jpg" width="280">  | <img src="http://bahareng.com/assets/1.jpg" width="280">







## Installation ✈️

Install the application with gradle wrapper command

```gradle
  gradlew assembleDebug
  gradlew installDebug
```

But if you want to **launch** the application through the command line, after Installation navigate to your SDK's `platform-tools/` directory and run the following command:
    
 ```gradle
   adb shell am start -a android.intent.action.MAIN -n com.little.virtuagym.app/.ui.MainActivity
```
## Running Tests 🧪

To run tests, run the following command

```bash
  gradlew app:connectedAndroidTest
```


## Libraries and tools 🛠

- ROOM Database
- Data Binding
- Coroutine
- Navigation component 
- LiveData
- Dagger Hilt


## Appendix

Contact address

* Email  : arashsammak@gmail.com
