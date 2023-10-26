describe("Visual Regression Test", () => {
    it("should match the profile page", () => {
      // Visit the URL
      cy.visit("https://www.blazingchat.com/");
      cy.contains('Login').click();
  
      // Capture a screenshot of the page
      cy.screenshot("profile-page");
  
      // Compare the screenshot to the baseline
      cy.matchImageSnapshot("profile-page");
    });
  });