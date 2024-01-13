import {Match} from "./Match";
import {Season} from "./Season";

export interface MatchDay {
  id: number;
  startDate: Date;
  endDate: Date;
  season: Season;
  matches: Match[];
}
