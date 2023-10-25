export interface OpportunityFormDTO {
  requiredQuantity: number;
  expectedRevenue: number;
  probability: number;
  expectedClosingDate: Date;
  products: string;
  status: string;
  source: string;
  accountName: string;
}

