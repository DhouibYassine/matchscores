import {Component} from '@angular/core';
import {Match} from "../model/Match";
import {MatchDayService} from "../service/match-day.service";
import {DatePipe} from "@angular/common";
import {KeycloakService} from "keycloak-angular";
import {MatchDay} from "../model/MatchDay";
import {DataService} from "../service/data.service";

@Component({
  selector: 'app-match-cards',
  templateUrl: './match-cards.component.html',
  styleUrls: ['./match-cards.component.scss']
})
export class MatchCardsComponent {

  matchDayId!:number;
  matchDay!: MatchDay;
  matches!: Match[];

  longDate!: Date;
  formattedDate!: String;

  longStartDate!: Date;
  formattedStartDate!: String;
  longEndDate!: Date;
  formattedEndDate!: String;

  constructor(private matchDayService: MatchDayService,
              private datePipe: DatePipe,
              public keycloakService: KeycloakService,
              private dataService: DataService
  ) {
  }

  ngOnInit() {
    this.dataService.data$.subscribe(
      data => {
        this.matchDayId=data;
        this.getMatchDay();
      }
    )
  }

  getFormattedYear(originalDate: Date): string {
    return <string>this.datePipe.transform(originalDate, 'yyyy');
  }
  getFormattedDate(dateString: Date): string {
    const date = new Date(dateString);
    return <string>this.datePipe.transform(date, 'yyyy-MM-dd');
  }

  getMatchDay(): void {
    this.matchDayService.getById(this.matchDayId).subscribe({
      next: matchDay => {
        this.matchDay = matchDay;
        this.matches = matchDay.matches;
        this.longDate = this.matchDay.season.startingDate;
        this.formattedDate = this.getFormattedDate(this.longDate);
        this.longStartDate = this.matchDay.season.startingDate;
        this.longEndDate = this.matchDay.season.endingDate;
        this.formattedStartDate = this.getFormattedYear(this.longStartDate);
        this.formattedEndDate = this.getFormattedYear(this.longEndDate);
      },
      error: () => {
        this.matches = [];
      }
    });
  }

  delete(id: number): void {
  //   const dialogRef = this.dialog.open(ConfirmDialogComponent, {
  //     height: '170px',
  //     width: '380px',
  //   });
  //
  //   dialogRef.afterClosed().subscribe((x) => {
  //     if (x) {
  //       this.HS.deleteHotel(id).subscribe(() => {
  //         this.getHotels();
  //       });
  //     }
  //   });
  }

  edit(id:number): void {
    // const dialogConfig = new MatDialogConfig();
    // dialogConfig.disableClose = true;
    // dialogConfig.autoFocus = true;
    // this.HS.getHotelById(id).subscribe((hotel) => {
    //   this.hotel = hotel;
    //   dialogConfig.data = this.hotel;
    //   this.dialog.open(EditModalComponent, dialogConfig).afterClosed().subscribe(() => {
    //     this.getHotels();
    //   });
    // });
  }
}
