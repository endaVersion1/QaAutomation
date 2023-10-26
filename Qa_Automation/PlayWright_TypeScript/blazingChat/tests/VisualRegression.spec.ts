import { test, expect } from '@playwright/test';

test.describe( 'Open blazing Chat', ()=> {

    test(`Open page and Wait`, async ({ page }) => {
      await page.goto('https://www.blazingchat.com/');
      await page.getByRole('button', { name: 'Login' }).click();
      await page.waitForURL('https://www.blazingchat.com/profile');
      await expect(page).toHaveScreenshot();
    });
});
