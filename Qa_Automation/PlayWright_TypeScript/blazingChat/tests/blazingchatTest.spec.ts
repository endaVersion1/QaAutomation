import { test, expect } from '@playwright/test';
import { BlazingChatPage } from './blazingChatPage.page';

test.describe( 'Open blazing Chat', ()=> {

    test(`Open page and Wait`, async ({ page }) => {
      const blazingChatPage = new BlazingChatPage(page);
      const profilePicture = '../../qa_cat.jpg'

      await page.goto('https://www.blazingchat.com/');
      await blazingChatPage.loginButton.click();
      await expect(page).toHaveURL('https://www.blazingchat.com/profile');
      await blazingChatPage.uploadPicture(profilePicture);
      await blazingChatPage.verifyAlertMessage();
    });

    //---Code Challenge Check Create account validation--
    test(`Create Account`, async ({ page }) => {

    });

    //---Code Challenge Check Create account validation--
    test(`Create Account Validation`, async ({ page }) => {

    });

});
