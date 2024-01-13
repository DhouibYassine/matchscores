import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MatchDay} from "../model/MatchDay";

@Injectable({
  providedIn: 'root'
})
export class MatchDayService {

  matchDayApiUrl: string = 'http://localhost:8089/league-service/matchDay';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<MatchDay[]> {
    return this.httpClient.get<MatchDay[]>(this.matchDayApiUrl);
  }

  getById(id: number): Observable<MatchDay> {
    return this.httpClient.get<MatchDay>(this.matchDayApiUrl + "/" + id);
  }

  save(matchDay: MatchDay): Observable<MatchDay> {
    return this.httpClient.post<MatchDay>(this.matchDayApiUrl, matchDay);
  }

  update(matchDay: MatchDay): Observable<MatchDay> {
    return this.httpClient.put<MatchDay>(this.matchDayApiUrl + "/" + matchDay.id, matchDay);
  }

  delete(id: number): Observable<MatchDay> {
    return this.httpClient.delete<MatchDay>(this.matchDayApiUrl + "/" + id);
  }

}
