import {Component} from '@angular/core';
import {MatchDay} from "../model/MatchDay";
import {MatTableDataSource} from "@angular/material/table";
import {MatchDayService} from "../service/match-day.service";
import {Match} from "../model/Match";
import {KeycloakService} from "keycloak-angular";
import {DatePipe} from '@angular/common';
import {DataService} from "../service/data.service";
import {Team} from "../model/Team";

@Component({
  selector: 'app-match-day',
  templateUrl: './match-day.component.html',
  styleUrls: ['./match-day.component.scss']
})
export class MatchDayComponent {
  matchDay!: MatchDay;
  dataSource!: MatTableDataSource<Match>;

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

  getFormattedYear(originalDate: Date): string {
    return <string>this.datePipe.transform(originalDate, 'yyyy');
  }

  ngOnInit(): void {
    this.dataSource = new MatTableDataSource<Match>();
    this.getMatchDay();
  }

  displayedColumns: string[] = ['homeTeamName', 'score', 'awayTeamName', 'icon'];

  getMatchDay(): void {
    this.matchDayService.getById(1).subscribe({
      next: matchDay => {
        this.matchDay = matchDay;
        this.dataSource.data = matchDay.matches;
        this.longStartDate = this.matchDay.season.startingDate;
        this.longEndDate = this.matchDay.season.endingDate;
        this.formattedStartDate = this.getFormattedYear(this.longStartDate);
        this.formattedEndDate = this.getFormattedYear(this.longEndDate);
      },
      error: () => {
        this.dataSource.data = [];
      }
    });
  }

  // save() {
  //   if (this.form.valid) {
  //     this.CS.save({
  //       cin: this.form.value.cin,
  //       firstName: this.form.value.firstName,
  //       lastName: this.form.value.lastName,
  //       address: this.form.value.address,
  //     }).subscribe({
  //       next: () => {
  //         this.getClients();
  //         this.form.reset();
  //       },
  //       error: err => {
  //         this.error_state = true;
  //         this.error_message = err.error.message;
  //       }
  //     });
  //   }
  // }

  edit(id: number) {
    //   const dialogConfig = new MatDialogConfig();
    //   dialogConfig.disableClose = true;
    //   dialogConfig.autoFocus = true;
    //   this.CS.getByCin(cin).subscribe((matchDay) => {
    //     this.matchDay = matchDay;
    //     dialogConfig.data = this.matchDay;
    //     this.dialog.open(ClientEditModalComponent, dialogConfig).afterClosed().subscribe(() => {
    //       this.getClients();
    //     });
    //   });
  }

  delete(id: number) {
    //   const dialogRef = this.dialog.open(ConfirmDialogComponent, {
    //     height: '180px',
    //     width: '220px',
    //   });
    //   dialogRef.afterClosed().subscribe((x) => {
    //     if (x) {
    //       this.CS.delete(cin).subscribe({
    //         next: () => {
    //           this.getClients();
    //         },
    //         error: () => {
    //         }
    //       });
    //     }
    //   });
  }

  // applyFilter(event: Event) {
  //   const filterValue = (event.target as HTMLInputElement).value;
  //   this.dataSource.filter = filterValue.trim().toLowerCase();
  // }

  details(matchDayId: number) {
    this.dataService.sendData(matchDayId)
  }

  detailsTeam(team: Team) {
    const data = {
      team: team,
      seasonStartDate : this.formattedStartDate,
      seasonEndDate : this.formattedEndDate,
    }
    this.dataService.sendData(data)
  }
}
