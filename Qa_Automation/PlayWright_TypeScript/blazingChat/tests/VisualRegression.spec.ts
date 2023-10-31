import { test, expect } from '@playwright/test';

test.describe( 'Open blazing Chat', ()=> {

    test(`Viusal Regression Login Page`, async ({ page }) => {
      await page.goto('https://www.blazingchat.com/');
      await page.getByRole('button', { name: 'Login' }).click();
      await page.waitForURL('https://www.blazingchat.com/profile');
      await expect(page).toHaveScreenshot();
    });

//---Code Challenge Check Create account validation--
    test(`Viusal Regression Create Account Page`, async ({ page }) => {
      await page.goto('https://www.blazingchat.com/');
    });
});
