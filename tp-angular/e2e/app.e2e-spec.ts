import { TpAngularPage } from './app.po';

describe('tp-angular App', () => {
  let page: TpAngularPage;

  beforeEach(() => {
    page = new TpAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
