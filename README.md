SplitSmart App


Course: OPSC POE
Platform: Android Studio (Kotlin + XML)
Language Support: English & Multilingual
Offline Support: Enabled
Notifications: Implemented for alerts, updates, and deletions

Overview

SplitSmart is an intuitive Android app designed to simplify the process of splitting expenses, managing shared costs, and maintaining transparent financial records between multiple users. The app allows users to manage their budgets both online and offline, ensuring accessibility even without an active internet connection.

It includes a Settings Fragment for language preferences, notifications, and data synchronization options. The app’s clean interface and efficient Kotlin-based backend ensure smooth performance and usability.

 Key Features

 Multi-language Support – Change app language dynamically from settings.

 Notifications System – Alerts users about updates, deletions, and new data.

offline Sync – Saves and updates data even without an internet connection.

 Settings Fragment – Manage preferences and notifications.

 Expense Tracking – Add, edit, and view all shared expenses.

 Data Persistence – Stores data locally with Room Database for offline reliability.

 Tech Stack
Component	Technology
Programming Language	Kotlin
UI Layouts	XML
IDE	Android Studio
Database	Room (Offline Persistence)
Notifications	Android Notification Manager
Version Control	GitHub
Logging	Android Logcat (Log.d / Log.i / Log.e)
AI Acknowledgement

During the development of SplitSmart, ChatGPT (OpenAI GPT-5) was used as a supporting tool for debugging, clarifying syntax errors, optimizing Kotlin code structure, and designing the app logo concept.
All AI-assisted content was reviewed, tested, and understood before integration.
See the full AI acknowledgment section in the project documentation or Word submission.
 Video Demonstration

Video Presentation (Unlisted YouTube Link):
https://youtube.com/@itexpert-oe8qt?si=Syb9RG_Wd0zy9iX0

(The video includes a walkthrough of all app features, showing the UI, settings fragment, multilingual options, offline sync, and notification functionality.)

Screenshots of the app:
Welcome page ~ <img width="330" height="595" alt="ss_welcome 1" src="https://github.com/user-attachments/assets/e895ae54-beb6-4c0d-b861-2704b22cd108" />
Login page ~ <img width="408" height="727" alt="ss_login 1" src="https://github.com/user-attachments/assets/be65543b-9b73-4f64-b6de-35de23f90d03" />
Sign up page ~ <img width="330" height="591" alt="ss_signup 1" src="https://github.com/user-attachments/assets/a9c9bfea-bf9d-4b77-84c4-92481b27831c" />
View Group Page ~ <img width="333" height="595" alt="ss_viewGroup 1" src="https://github.com/user-attachments/assets/7be1d805-db1f-438f-90b4-760908bdd010" />
Add expense ~ <img width="330" height="593" alt="ss_addExpense 1" src="https://github.com/user-attachments/assets/16b86dd0-940e-4501-aeeb-9ed7cd8b813a" />
Recent activity~ <img width="333" height="595" alt="ss_recentActivity 1" src="https://github.com/user-attachments/assets/9fc9984f-9e66-4f61-b2f6-de9cf2193d55" />
Add group ~ <img width="332" height="596" alt="ss_addGroup 1" src="https://github.com/user-attachments/assets/88192f48-2343-4c01-9640-4103f306a75b" />
Home page~ <img width="333" height="592" alt="ss_1stPage 1" src="https://github.com/user-attachments/assets/e5326805-4bac-4462-8923-e4479a67263c" />
View expense ~ <img width="331" height="591" alt="ss_viewExpense 1" src="https://github.com/user-attachments/assets/566b7409-6420-4c5d-82a7-d14425411928" />

 How to Run the App

Clone the repository:

git clone https://github.com/yourusername/SplitSmartApp.git


Open the project in Android Studio.

Sync Gradle files.

Run the app on an emulator or Android device.

🧾 Logging Example
Log.d("SplitSmart", "Expense added successfully: $expenseName")
Log.i("SyncManager", "Offline data synced with server")
Log.e("NotificationService", "Error displaying notification: ${e.message}")
