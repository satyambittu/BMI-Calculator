# ⚖️ BMI Calculator

This project is a modern, full-stack **Body Mass Index (BMI) Calculator** built with a hybrid tech stack: **Java (backend)**, **XML-based UI** (possibly Android or JavaFX), and optionally MERN stack components for the web interface.

---

## 📌 Overview

The BMI Calculator allows users to input their height and weight and get an accurate Body Mass Index reading along with a health category suggestion (Underweight, Normal, Overweight, Obese). The app is available with both native and web-based interfaces.

---

## 🧠 Core Features

- Accepts user height (in cm or ft/in) and weight (in kg or lbs)
- Calculates BMI with real-time feedback
- Displays BMI category with color-coded UI
- Responsive XML-based UI (for mobile/native) and optional React frontend
- Java backend API or logic layer for core computation

---

## 🛠️ Tech Stack

| Layer       | Technologies Used              |
|-------------|---------------------------------|
| Backend     | Java (core logic, optional APIs) |
| UI (Native) | XML UI (Android/JavaFX)         |
| Web Frontend| React (MERN stack)              |
| API (Web)   | Node.js, Express (upcoming)             |
| Database    | MongoDB (optional for logs/users) |

---

## ⚙️ How It Works

```text
[ User Input (Height, Weight) ]
            ↓
[ Java Logic / MERN API ]
            ↓
[ BMI Value + Category Displayed ]
```

**BMI Formula:**

```text
BMI = weight (kg) / [height (m)]²
```

---

## 📦 Project Structure

```
BMI-Calculator/
├── backend/         # Java logic or Node.js APIs
├── frontend/        # React interface
├── mobile-ui/       # XML-based UI files
├── README.md
```

---

## 🧪 Usage

### Local Setup

```bash
git clone https://github.com/satyambittu/BMI-Calculator
cd BMI-Calculator

# For MERN:
cd frontend && npm install && npm start
cd ../backend && npm install && npm run dev
```

### Native Java Version
Run `Main.java` or import project in Android Studio / IntelliJ.

---

## ✅ Sample Output

| Input        | Result     |
|--------------|------------|
| Height: 170cm | BMI: 22.5 |
| Weight: 65kg  | Category: Normal Weight |

---

## 👤 Author

**Satyam Kumar**  
🔗 [GitHub](https://github.com/satyambittu)

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).
