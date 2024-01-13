import {Component} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Team} from "../model/Team";
import {KeycloakService} from "keycloak-angular";
import {DataService} from "../service/data.service";
import {Player} from "../model/Player";

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.scss']
})
export class TeamComponent {

  team!: Team;
  dataSource!: MatTableDataSource<Player>;

  startDate!: String;
  endDate!: String;

  constructor(private dataService: DataService
  ) {
  }

  ngOnInit(): void {
    this.dataService.data$.subscribe(
      data => {
        this.team = data.team;
        this.startDate = data.seasonStartDate;
        this.endDate = data.seasonEndDate;
      }
    )
    this.dataSource = new MatTableDataSource<Player>(this.team.players);

  }

  displayedColumns: string[] = ['name', 'age', 'position', 'nationality'];


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
}
