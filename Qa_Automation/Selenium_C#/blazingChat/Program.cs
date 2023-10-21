using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace blazingchat
{
    class Program
    {
        static void Main(string[] args)
        {
            // Set the path to the Chrome WebDriver executable
            string chromeDriverPath = @"webdriver/chromedriver.exe"; // Replace with the actual path

            // Configure the Chrome options
            ChromeOptions options = new ChromeOptions();
            options.AddArgument("--start-maximized"); // Maximize the browser window

            // Initialize the Chrome WebDriver with the specified options
            IWebDriver driver = new ChromeDriver(chromeDriverPath, options);

            // Navigate to the specified URL
            string url = "https://www.blazingchat.com/";
            driver.Navigate().GoToUrl(url);

            // Wait for a few seconds to see the result (you can replace this with explicit waits)
            System.Threading.Thread.Sleep(5000);

            // Perform further actions on the web page if needed

            // Close the browser window
            driver.Quit();
        }
    }
}
