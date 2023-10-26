describe('My First Cypress Test', () => {
  it('Visits the homepage', () => {
    cy.visit('https://www.blazingchat.com/');
    cy.contains('Login');
  });
  it('Performs a search', () => {
    cy.visit('https://www.blazingchat.com/');
    cy.get('input[type="text"]').type('Cypress Testing');
    cy.get('button[type="submit"]').click();
    cy.url().should('include', 'search=Cypress+Testing');
  });
})
