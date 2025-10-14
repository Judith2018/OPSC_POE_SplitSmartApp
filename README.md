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
