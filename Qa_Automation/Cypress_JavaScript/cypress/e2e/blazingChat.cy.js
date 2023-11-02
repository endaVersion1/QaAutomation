describe('My First Cypress Test', () => {
  it('Visits the homepage', () => {
    cy.visit('https://localhost:44323/');
    cy.get('h2').contains('Login');
  });
  
  it('Performs a search for user who does exist', () => {
    cy.visit('https://localhost:44323/');
    cy.get('#button_login').click();
    cy.url().should('include', 'profile');
  //Serach through l;ist of contacts
    cy.get('[href="contacts"]').click();
    // assert the element's text content is exactly the given text
    cy.get('[href="/chat/1"]').contains('Julius Caesar');
  });

  it('Performs a search for user who does not exist', () => {
    cy.visit('https://localhost:44323/');
    cy.get('#button_login').click();
    cy.url().should('include', 'profile');
  //Serach through l;ist of contacts
  cy.get('[href="contacts"]').click();
    // assert the element's text content is exactly the given text
    cy.get('[href="/chat/1"]').contains('Tom Joens');
  });


  //---Code Challenge Check Create account validation--
  it('Create new account a search', () => {
    cy.visit('https://localhost:44323/');
    cy.get('href="/createaccount')
 });


 //---Code Challenge Check Create account validation--
 it('Check Create account Validation', () => {
  cy.visit('https://localhost:44323/');
});
})
