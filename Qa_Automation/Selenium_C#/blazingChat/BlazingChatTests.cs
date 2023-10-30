using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace blazingChat
{
    [TestFixture]
    public class BlazingChatTests
    {
        private IWebDriver driver;

    [SetUp]
    public void Setup()
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
    }

    [Test]
    public void VerifyProfileHeader()
    {
         // Login
            IWebElement loginButton = driver.FindElement(By.Id("button_login"));
            loginButton.Click();
            IWebElement h2Element = driver.FindElement(By.TagName("h2"));
            string actualText = h2Element.Text;
            Assert.AreEqual("Profile", actualText);

            //Select Contacts
            IWebElement contacts = driver.FindElement(By.XPath("//a[normalize-space()='Contacts']"));
            contacts.Click();
    }

//---Code Challenge Check Create account validation--
     public void VerifyUserNotAuth()
    {
         // Login
            IWebElement loginButton = driver.FindElement(By.Id("button_login"));
            loginButton.Click();
            IWebElement h2Element = driver.FindElement(By.TagName("h2"));
            string actualText = h2Element.Text;
            Assert.AreEqual("Profile", actualText);

            //Select Contacts
            IWebElement contacts = driver.FindElement(By.XPath("//a[normalize-space()='Contacts']"));
            contacts.Click();
            //Select User and verify Not Authorized
    }

    [TearDown]
    public void Cleanup()
    {
        // Close the browser when the test is done
        driver.Quit();
    }
        
    }
}