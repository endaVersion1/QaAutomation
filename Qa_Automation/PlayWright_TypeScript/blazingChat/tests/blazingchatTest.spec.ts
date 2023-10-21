import { test, expect } from '@playwright/test';

test.describe( 'Open blazing Chat', ()=> {

    test(`Open page and Wait`, async ({ page }) => {
      await page.goto('https://www.blazingchat.com/');
      await page.pause();
    });
});
