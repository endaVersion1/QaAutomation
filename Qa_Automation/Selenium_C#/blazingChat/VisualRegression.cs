using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using Applitools;
using Applitools.Selenium;
using NUnit.Framework;
namespace blazingChat
{
    [TestFixture]
    public class VisualRegression
    {
        [SetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            eyes = new Eyes();
            eyes.ApiKey = "YOUR_APPLITOOLS_API_KEY";
        }

        [Test]
        public void Test1()
        {
            Assert.Pass();
        }
    }
}