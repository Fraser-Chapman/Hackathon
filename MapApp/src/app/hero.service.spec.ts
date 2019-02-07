import { TestBed } from '@angular/core/testing';

import { LikelihoodService } from './LikelihoodService';

describe('HeroService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LikelihoodService = TestBed.get(LikelihoodService);
    expect(service).toBeTruthy();
  });
});
