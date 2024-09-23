import { TestBed } from '@angular/core/testing';

import { AuthGuardsService } from './auth-guards';

describe('AuthGuardsService', () => {
  let service: AuthGuardsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthGuardsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
