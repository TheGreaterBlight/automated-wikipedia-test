# automated-wikipedia-test
Cross-browser test automation framework using Selenium, TestNG, and BrowserStack. Includes Wikipedia test automation with Allure reporting and Cucumber support.

## Java Test Automation Framework (Selenium + BrowserStack)

A full-featured Java-based automation framework for UI testing, supporting local and cloud-based (BrowserStack) test execution.

### ✅ Key Features

- Automates Wikipedia search functionality using **Selenium WebDriver**
- Cross-browser testing on **BrowserStack**
- **BDD** support via Cucumber
- **TestNG** for structured test execution
- **Allure** for rich HTML reporting
- **Maven** for build and dependency management
- **Lombok** and **Awaitility** to streamline code and async waits

### 🌐 Test Scenario Example: Wikipedia

- Open [Wikipedia](https://www.wikipedia.org)
- Search for a term (e.g., “Selenium (software)”)
- Verify the title or content contains the expected result

### ☁️ BrowserStack Integration

Tests can be run on:
- Chrome, Firefox, Safari
- Windows, macOS, and mobile devices
- Via BrowserStack's remote cloud infrastructure

### 🧪 Technologies Used

| Tool/Library         | Purpose                         |
|----------------------|----------------------------------|
| Selenium WebDriver   | UI automation                   |
| TestNG               | Test management                 |
| Cucumber             | BDD & feature files             |
| Allure               | Test reports                    |
| BrowserStack         | Cross-browser cloud testing     |
| Maven                | Build tool & dependencies       |
| Lombok               | Code simplicity                 |
| Awaitility           | Async waits                     |

### 🚀 How to Run

```bash
mvn clean test

export BROWSERSTACK_USERNAME=your_user
export BROWSERSTACK_ACCESS_KEY=your_key
