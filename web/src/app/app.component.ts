import { Component, resolveForwardRef, HostListener } from '@angular/core';
import { AppService } from './app.service';
import { Task } from './task.model';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'consumer';
  typesOfShoes: string[] = [
    'Boots',
    'Clogs',
    'Loafers',
    'Moccasins',
    'Sneakers',
  ];
  tasks: Task[] = [];
  taskToAddDescription = '';

  constructor(private service: AppService, private formBuilder: FormBuilder) {
    this.service.getAllTasks().subscribe((data: Task[]) => {
      console.log(data);
      this.tasks = data;
    });
  }

  deleteTask(id: number): void {
    console.log('delete task ' + id);
    this.service.deleteTask(id).subscribe((data: any) => {
      console.log(data);
      const taskToDelete = this.tasks.find((task) => task.id === id);
      const index = this.tasks.indexOf(taskToDelete, 0);
      if (index > -1) {
        this.tasks.splice(index, 1);
      }
    });
  }

  addTask(): void {
    console.log('add taks with description: ' + this.taskToAddDescription);
    this.service.addTask(this.taskToAddDescription).subscribe((data: Task) => {
      console.log(data);
      this.tasks.push(data);
      this.taskToAddDescription = '';
    });
  }

  @HostListener('window:keyup', ['$event'])
  keyEvent(event: KeyboardEvent): void {
      if (event.key !== undefined && event.key === 'Enter') {
        this.addTask();
      }
  }
}
