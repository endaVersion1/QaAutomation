import { test, expect } from '@playwright/test';
import { BlazingChatPage } from './blazingChatPage.page';
import * as data from '../../blazingChat/tests/data/contacts.json';

// Our Mocked API data
const mock = data[0]; // Access the first element of the array

test.describe('Open Blazing Chat', () => {
    test('Login in and Mock Contacts', async ({ page }) => {
        const blazingChatPage = new BlazingChatPage(page);
        await page.goto('https://www.blazingchat.com/');
        await blazingChatPage.loginButton.click();
        await page.waitForURL('https://www.blazingchat.com/profile');
        await page.pause();
        await page.getByText('Contacts').click();
        
        await page.pause();
        await page.route('https://blazingchatwebapi.azurewebsites.net/contacts/getvisiblecontacts?startIndex=0&count=18', (route) => {
            route.fulfill({
                status: 200,
                contentType: 'application/json; charset=utf-8',
                headers: { 'Access-Control-Allow-Origin': 'https://www.blazingchat.com' },
                body: JSON.stringify([mock]),
            });
        });

        // Use 'expect' to make assertions about the page content
        await expect(page.locator('href')).toContainText('Enda Brody'); 
    });
});