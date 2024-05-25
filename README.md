# Spring Utilities

Spring Beans that would be useful in any Spring project. This will replace SDJK, JavaUtil and FileUtil. It would be easier to strip out the Spring in the future than to add it in

-----------------------------

### [GIT location](https://github.com/sobemurray/Spring-Utils.git)

-----------------------------

### Maven details

> groupId - com.sobetech.maven
>
> artifactId - template

-----------------------------

# Releases

## 1.0.7
##### 05-24-2024
#### SU-16
Fixed StringEnum to make sense. getValue should have been getDescription all along
#### SU-17
Added EditStatus enum
#### FDI-84
- Added isActive as a default for StringEnum. This allow for them to be flagged as inactive. See NFLTeam for implementation
- Added isPrivate as a default for StringEnum. This allow for them to be flagged as private and not sent to UIs

## 1.0.6
##### 05-21-2024
#### FDI-78
Removed Enum serializers that shouldn't have been necessary

## 1.0.5
##### 05-19-2024
#### FDI-66
Added a new ErrorCode for when the user making the request is logged out

## 1.0.4
##### 05-17-2024
#### FDI-57 
Cleaned up ErrorCode. 
Added protected setters to ApiRuntimeException for it's children
Added exception for login issues
Made almost all POM dependencies provided scope because the final application should have to provide them

## 1.0.3
##### 05-14-2024
#### SU-14
Renamed packages to have the general functionality first and Spring second

## 1.0.2
##### 05-08-2024
#### SU-10
Open any text file and convert into a List of Strings

## 1.0.1
##### 05-06-2024
#### SU-7
Bug fixes found post-merge
Moved import results into it's own package
Created an object to hold year data in the results

## 1.0.0
##### 05-04-2024
#### SU-5
Finished migration of code from JavaUtil and FileUtil
Added in the Jackson and Swagger dependent classes
Migrated most of the code from Football Importer to this

## 0.0.1
##### 05-03-2024
#### SU-1
Initial project creation
#### SU-5
Initial migration and re-packaging

-----------------------------
